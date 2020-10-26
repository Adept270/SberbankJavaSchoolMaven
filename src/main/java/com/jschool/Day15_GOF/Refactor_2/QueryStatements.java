package com.jschool.Day15_GOF.Refactor_2;

public class QueryStatements {

    private static final String selectEmpData = "select " +
            "emp.id as emp_id, " +
            "emp.name as amp_name, " +
            "sum(salary) as salary " +
            "from employee emp " +
            "left join salary_payments sp on emp.id = sp.employee_id" +
            "where emp.department_id = ? and sp.date >= ? and sp.date <= ? " +
            "group by emp.id, emp.name";

    public static String getSelectEmpData() {
        return selectEmpData;
    }
}
