package study.apps;
import java.math.BigDecimal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
record ShippingInput(Integer weightGrams){}
record ShippingResult(String region,int band,BigDecimal price){}
@Service
class Domain {
 final String region;
 Domain(@Value("${shipping.region}")String region){if(!java.util.Set.of("EU","LOCAL").contains(region))throw new IllegalArgumentException("REGION_invalid");this.region=region;}
 ShippingResult calculate(Integer grams){
  if(grams==null||grams<1||grams>30000)throw new Problem(400,"invalid_weight");
  int band=grams<=1000?1:grams<=5000?2:3;
  String[] prices=region.equals("EU")?new String[]{"3.00","7.50","12.00"}:new String[]{"2.00","4.50","8.00"};
  return new ShippingResult(region,band,new BigDecimal(prices[band-1]));
 }
}
@RestController
class Controller {
 final Domain domain;Controller(Domain domain){this.domain=domain;}
 @GetMapping("/health/live") Map<String,String> live(){return Map.of("status","ok");}
 @PostMapping("/shipping-quote") ShippingResult quote(@RequestBody ShippingInput input){return domain.calculate(input.weightGrams());}
}
