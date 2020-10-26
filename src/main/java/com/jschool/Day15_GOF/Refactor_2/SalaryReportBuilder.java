package com.jschool.Day15_GOF.Refactor_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SalaryReportBuilder {
    private final Connection connection;

    public SalaryReportBuilder(Connection connection) {
        this.connection = connection;
    }

    public String buildHtmlReport(String departmentId, LocalDate dateFrom, LocalDate dateTo) {
        ResultSet results = getReportData(departmentId, dateFrom, dateTo);
        StringBuilder resultingHtml = generateHtmlReport(results);
        return resultingHtml.toString();
    }

    private StringBuilder generateHtmlReport(ResultSet results) {
        StringBuilder resultingHtml = new StringBuilder();
        resultingHtml.append("<html><body><table><tr><td>Employee</td><td>Salary</td></tr>");
        double totals = 0;
        try {
            while (results.next()) {
                resultingHtml.append("<tr>");
                resultingHtml.append("<td>").append(results.getString("emp_name")).append("</td>");
                resultingHtml.append("<td>").append(results.getDouble("salary")).append("</td>");
                resultingHtml.append("</tr>");
                totals += results.getDouble("salary");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resultingHtml.append("<tr><td>Total</td><td>").append(totals).append("</td></tr>");
        resultingHtml.append("</table></body></html>");
        return resultingHtml;
    }

    private ResultSet getReportData(String departmentId, LocalDate dateFrom, LocalDate dateTo) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    QueryStatements.getSelectEmpData());
            ps.setString(0, departmentId);
            ps.setDate(1, new java.sql.Date(dateFrom.toEpochDay()));
            ps.setDate(2, new java.sql.Date(dateTo.toEpochDay()));

            return ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
