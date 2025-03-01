### Problem Statement:

You are tasked with writing an **SQL query** to analyze customer purchase behavior based on the given database structure. Your goal is to:

1. **Select all customers who purchased an average of more than 2 items per order.**

   - The average should be calculated by dividing the total number of items purchased by a customer by the total number of orders placed by the customer.

2. **Columns to display in the output:**

   - `CUSTOMER_ID` (unique ID of the customer),
   - `FIRSTNAME` (customer's first name),
   - `LASTNAME` (customer's last name),
   - `AVG` (average number of items purchased per order).

3. **Formatting the average value (`AVG`):**

   - The field type of `AVG` must be of type **`DECIMAL`**, with two decimal places (e.g., 2.50, 2.75, etc.), not a float or integer.

4. **Sort the Result:**

   - Sort the results in **descending order of the average number of items purchased (`AVG`).** This means customers with the highest average appear at the top.

5. **Filtering Output:**

   - Only include customers whose average number of items purchased per order is greater than 2.

6. **Database Schema:**

   - You have the following tables in the database:

   #### `customer` Table:

   - `customer_id` (INTEGER): Unique ID for each customer
   - `firstname` (VARCHAR): First name of the customer
   - `lastname` (VARCHAR): Last name of the customer
   - More columns related to customer details (e.g., birth_date, address, phone_number).

   #### `purchase_order` Table:

   - `order_id` (INTEGER): Unique ID for each order
   - `customer_id` (INTEGER): Foreign key referencing `customer_id` in the `customer` table
   - `date` (DATE): Date the order was placed.

   #### `order_product` Table:

   - `order_id` (INTEGER): Foreign key referencing `order_id` in the `purchase_order` table
   - `product_id` (INTEGER): Foreign key referencing `product_id` in the `product` table
   - Each row in this table represents one product from the linked order.

   #### `product` Table:

   - Details about the products purchased, not used directly in this query.

7. **Expected Output:**

   - For example:
     ```
     | CUSTOMER_ID | FIRSTNAME | LASTNAME | AVG  |
     |-------------|-----------|----------|------|
     | 3           | Tomas     | Smith    | 2.75 |
     | 5           | Paul      | Newton   | 2.50 |
     ```

8. **Database Query Language:**
   - Use **ANSI SQL** syntax for compatibility.
   - Use proper joins (`INNER JOIN ... ON`) instead of deprecated join syntax.

### Deliverables:

Provide a complete SQL query that meets all the above requirements and produces accurate results. Sort and filter the data as specified. Ensure that the `AVG` column is correctly formatted to two decimal places.

Here is the **SQL query** to retrieve customers who purchased an average of more than 2 items per order, formatted to two decimal places and sorted in descending order:

### **SQL Query:**

```sql
SELECT
    c.customer_id,
    c.firstname,
    c.lastname,
    ROUND(CAST(COUNT(op.product_id) AS DECIMAL) / COUNT(DISTINCT po.order_id), 2) AS AVG
FROM customer c
JOIN purchase_order po ON c.customer_id = po.customer_id
JOIN order_product op ON po.order_id = op.order_id
GROUP BY c.customer_id, c.firstname, c.lastname
HAVING ROUND(CAST(COUNT(op.product_id) AS DECIMAL) / COUNT(DISTINCT po.order_id), 2) > 2
ORDER BY AVG DESC;
```

---

### **Explanation:**

1. **Joins:**

   - The query joins three tables:
     - `customer` (`c`) → Contains customer details.
     - `purchase_order` (`po`) → Links customers to their orders.
     - `order_product` (`op`) → Links orders to products, allowing us to count items.

2. **Calculating the Average Number of Items per Order:**

   - **`COUNT(op.product_id)`** → Counts the total number of items purchased by a customer.
   - **`COUNT(DISTINCT po.order_id)`** → Counts the total number of unique orders placed by the customer.
   - The **average** is computed as:
     \[
     \text{AVG} = \frac{\text{Total Items Purchased}}{\text{Total Orders Placed}}
     \]
   - `ROUND(CAST(... AS DECIMAL), 2)` ensures the result is formatted with **two decimal places**.

3. **Filtering Results (`HAVING` Clause):**

   - `HAVING AVG > 2` ensures only customers with an **average purchase greater than 2 items per order** are included.

4. **Sorting the Output:**
   - `ORDER BY AVG DESC` → Sorts the results in **descending order** based on the computed average.

---

### **Example Result:**

| CUSTOMER_ID | FIRSTNAME | LASTNAME | AVG  |
| ----------- | --------- | -------- | ---- |
| 3           | Tomas     | Smith    | 2.75 |
| 5           | Paul      | Newton   | 2.50 |

This query ensures **accurate aggregation, correct formatting, filtering, and sorting** as per the problem statement. 🚀
