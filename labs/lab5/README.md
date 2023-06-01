# CMPE 172 - Lab #5 Notes

## Spring Rest Level 2

![](images/01_2_get_employees.png)
"Get Employees" returns `id`, `name`, and `role` of each employee.

![](images/02_2_get_employee_1.png)
"Get Employee 1" returns the `Employee` that has `id` = 1.

![](images/03_2_get_employee_99.png)
"Get Employee 99" returns no result because there is no
employee that has `id` = 99.

![](images/04_2_create_employee.png)
"Create Employee" creates an `Employee` with the parameters
in `Body` of the request and returns that `Employee` as the
response.

![](images/05_2_get_employee_3.png)
"Get Employee 3" returns the `Employee` that was just created.

![](images/06_2_update_employee_3.png)
"Update Employee 3" updates the `Employee` that has `id` = 3
with parameters found in the `Body` of the request and returns
that `Employee`.

![](images/07_2_delete_employee_3.png)
"Delete Employee 3" deletes the `Employee` that has `id` = 3.

![](images/08_2_create_employee.png)
"Create Employee" has the parameters `firstName` and `lastName`,
however, the database uses `name`, therefore the `name` in
the response is `null`.

![](images/09_2_update_employee.png)
"Update Employee" cannot find the `Employee` so it creates
a new `Employee` that has `role` set to "ring bearer".

![](images/10_2_get_orders.png)
`Order` has not yet been implemented so "Get Orders" returns
404 Not Found.

![](images/11_2_cancel_order.png)
`Order` has not yet been implemented so "Cancel Orders" 
returns 404 Not Found.

![](images/12_2_complete_order.png)
`Order` has not yet been implemented so "Complete Orders"
returns 404 Not Found.

## Spring Rest Level 3

![](images/13_3_get_employees.png)
"Get Employees" returns a list of `Employee`s with `id`, 
`firstName`, `lastName`, `role`, `name`, and `_links`.

![](images/14_3_get_employee_1.png)
"Get Employee 1" returns the `Employee` that has `id` = 1.

![](images/15_3_get_employee_99.png)
"Get Employee 99" returns nothing because there is no
`Employee` with `id` = 99.

![](images/16_3_create_employee.png)
"Create Employee" creates an `Employee` with the provided
parameters. The `name` is split and used for `firstName`
and `lastName`, as implemented in the source code.

![](images/17_3_get_employee_3.png)
"Get Employee 3" returns nothing.

![](images/18_3_update_employee_3.png)
"Update Employee 3" cannot find the employee, so it
creates a new `Employee` instead.

![](images/19_3_delete_employee_3.png)
"Delete Employee 3" returns 500 Internal Server Error.

![](images/20_3_create_employee.png)
"Create Employee" using `firstName` and `lastName`.

![](images/21_3_update_employee.png)
"Update Employee" cannot find the employee, so it
creates a new `Employee`.

![](images/22_3_get_orders.png)
"Get Orders" returns a list of orders.

![](images/23_3_cancel_order.png)
"Cancel Order" cancels the `Order` with `id` = 4 and 
changes the `status` from "IN_PROGRESS" to "CANCELLED".

![](images/24_3_complete_order.png)
The `Order` with `id` = 4 has been cancelled, so it cannot
be completed.
