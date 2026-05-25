CREATE TABLE expenses (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100),
    amount NUMERIC(10,2),
    category VARCHAR(50),
    expense_date DATE
);