CREATE TABLE product
(
    id       INTEGER      NOT NULL,
    name     VARCHAR(255) NOT NULL,
    measure  VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    price    NUMERIC      NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE recipe
(
    id   INTEGER      NOT NULL,
    name VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE recipe_ingredient
(
    recipe_id  INTEGER          NOT NULL,
    product_id INTEGER          NOT NULL,
    amount     DOUBLE PRECISION NOT NULL,

    PRIMARY KEY (recipe_id, product_id)
);

CREATE TABLE fridge_product
(
    product_id INTEGER          NOT NULL,
    amount     DOUBLE PRECISION NOT NULL,

    PRIMARY KEY (product_id)
);
