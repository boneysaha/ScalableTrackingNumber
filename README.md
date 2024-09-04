curl --location 'localhost:8080/next-tracking-number?origin_country_id=test1&destination_country_id=test&weight=test&created_at=test&customer_id=test&customer_name=test&customer_slug=test'

request:
localhost:8080/next-tracking-number?origin_country_id=test1&destination_country_id=test&weight=test&created_at=test&customer_id=test&customer_name=test&customer_slug=test

response:
{
    "trackingNumber": "899D324A-B6D7-3C55-987F-03A9693BFF82",
    "createdAt": "2024-09-04T12:51:13.624"
}
