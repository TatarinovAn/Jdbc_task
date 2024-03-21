SELECT product_name
FROM netology.customers
         JOIN netology.ORDERS ON netology.customers.id = netology.ORDERS.customer_id
WHERE name = LOWER(:name);