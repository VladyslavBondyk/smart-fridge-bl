INSERT INTO product (id, name, measure, category, price) VALUES (1, 'Борошно', 'KILOGRAM', 'GROCERY', 50);
INSERT INTO product (id, name, measure, category, price) VALUES (2, 'Яйця', 'PACK', 'GROCERY', 26);
INSERT INTO product (id, name, measure, category, price) VALUES (3, 'Кетчуп гострий', 'KILOGRAM', 'SOUCE', 54);
INSERT INTO product (id, name, measure, category, price) VALUES (4, 'Сир голандський', 'KILOGRAM', 'DAIRY', 140);
INSERT INTO product (id, name, measure, category, price) VALUES (5, 'Ковбаса Салямі', 'KILOGRAM', 'MEAT', 185);
INSERT INTO product (id, name, measure, category, price) VALUES (6, 'Кукурудза', 'KILOGRAM', 'GROCERY', 60);
INSERT INTO product (id, name, measure, category, price) VALUES (7, 'Капуста Пекінська', 'PIECE', 'VEGETABLES', 20);
INSERT INTO product (id, name, measure, category, price) VALUES (8, 'Курка копчена', 'KILOGRAM', 'MEAT', 300);
INSERT INTO product (id, name, measure, category, price) VALUES (9, 'Майонез', 'KILOGRAM', 'GROCERY', 120);
INSERT INTO product (id, name, measure, category, price) VALUES (10, 'Сухарі', 'KILOGRAM', 'GROCERY', 79);

INSERT INTO recipe (id, name) VALUES (1, 'Піцца Везувій');
INSERT INTO recipe (id, name) VALUES (2, 'Салат Цезар');

-- Піцца Везувій
INSERT INTO recipe_ingredient (recipe_id, product_id, amount) VALUES (1, 1, 0.5);
INSERT INTO recipe_ingredient (recipe_id, product_id, amount) VALUES (1, 2, 0.5);
INSERT INTO recipe_ingredient (recipe_id, product_id, amount) VALUES (1, 3, 0.1);
INSERT INTO recipe_ingredient (recipe_id, product_id, amount) VALUES (1, 4, 0.2);
INSERT INTO recipe_ingredient (recipe_id, product_id, amount) VALUES (1, 5, 0.1);
INSERT INTO recipe_ingredient (recipe_id, product_id, amount) VALUES (1, 6, 0.15);

-- Салат Цезар
INSERT INTO recipe_ingredient (recipe_id, product_id, amount) VALUES (2, 7, 1);
INSERT INTO recipe_ingredient (recipe_id, product_id, amount) VALUES (2, 2, 0.5);
INSERT INTO recipe_ingredient (recipe_id, product_id, amount) VALUES (2, 8, 0.1);
INSERT INTO recipe_ingredient (recipe_id, product_id, amount) VALUES (2, 9, 0.1);
INSERT INTO recipe_ingredient (recipe_id, product_id, amount) VALUES (2, 10, 0.05);

INSERT INTO fridge_product (product_id, amount) VALUES (1, 2);
INSERT INTO fridge_product (product_id, amount) VALUES (3, 2);
