CREATE TABLE coupons (
    "id" UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    "code" VARCHAR(255) NOT NULL,
    discount DECIMAL NOT NULL,
    event_id UUID NOT NULL,
    FOREIGN KEY (event_id) REFERENCES "events"("id")
);