# shipping-bands

Spring Boot4.0.3/Maven, Java17–25. `mvn -B test`, `mvn -B package` (includes tests),
`java -jar target/shipping-bands-0.1.0.jar`. PORT defaults to8301, listener0.0.0.0.
POST /shipping-quote {weightGrams}; REGION=EU(default) or LOCAL. Bands are inclusive at1000/5000g, maximum30000g; decimal prices.
No external state; process replacement loses in-memory allocations where applicable.
Liveness /health/live. 
Native tests include actual ephemeral loopback HTTP plus domain boundary checks.
AI-assisted researcher-created source, common scaffold disclosed separately. No deployment files or runtime credential values.
