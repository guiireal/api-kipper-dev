CREATE TABLE addresses (
    "id" UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    city VARCHAR(100) NOT NULL,
    "state" VARCHAR(20) NOT NULL,
    event_id UUID NOT NULL,
    FOREIGN KEY (event_id) REFERENCES "events"("id")
);