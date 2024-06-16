CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE IF NOT EXISTS "events" (
    "id" UUID PRIMARY KEY DEFAULT get_random_uuid(),
    title VARCHAR(50) NOT NULL,
    "description" VARCHAR(255) NOT NULL,
    img_url VARCHAR(255) NOT NULL,
    event_url VARCHAR(255) NOT NULL,
    "date" TIMESTAMP NOT NULL,
    is_remote BOOLEAN NOT NULL DEFAULT true
);

CREATE TABLE IF NOT EXISTS coupons (
    "id" UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    "code" VARCHAR(255) NOT NULL,
    discount DECIMAL NOT NULL,
    event_id UUID NOT NULL,
    FOREIGN KEY (event_id) REFERENCES "events"("id")
);

CREATE TABLE IF NOT EXISTS addresses (
    "id" UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    city VARCHAR(100) NOT NULL,
    "state" VARCHAR(20) NOT NULL,
    event_id UUID NOT NULL,
    FOREIGN KEY (event_id) REFERENCES "events"("id")
);