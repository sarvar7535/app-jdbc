package repository;

import entity.Currency;
import entity.Response;
import utils.DbConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyRepository {
    public static List<Currency> getCurrency() throws SQLException {
        Connection ulanish = DbConfig.ulanish();
        Statement statement = ulanish.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from  currency");
        List<Currency> currencyList = new ArrayList<>();
        while (resultSet.next()){
            Currency currency = new Currency();
            currency.setId(resultSet.getInt(1));
            currency.setName(resultSet.getString(2));
            currency.setActive(resultSet.getBoolean(3));
            currencyList.add(currency);
        }
        return currencyList;
    }

    public static  boolean addCurrency(int id,String name) throws SQLException {
        //oddiy parametrli querylar un
        Connection connection =DbConfig.ulanish();
        PreparedStatement preparedStatement= connection.prepareStatement(
                "insert into currency values(?,?,?)");
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);
        preparedStatement.setBoolean(3,true);

        return preparedStatement.execute();

    }

    public static Response callFunc(String name, String type, String n_name) throws SQLException {
        Response response = new Response();
        Connection connection = DbConfig.ulanish();
        CallableStatement callableStatement = connection.prepareCall(
                "{call add_currency(?,?,?,?,?)}");
        callableStatement.setString(1,name);
        callableStatement.setString(2,type);
        callableStatement.setString(3,n_name);
        callableStatement.registerOutParameter(4,Types.BOOLEAN);
        callableStatement.registerOutParameter(5,Types.VARCHAR);

        callableStatement.execute();
        response.setSuccess(callableStatement.getBoolean(4));
        response.setMessage(callableStatement.getString(5));
        return response;
    }
}
