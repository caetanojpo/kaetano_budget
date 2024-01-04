alter table users
add constraint unique_columns_constraint unique (email, username);