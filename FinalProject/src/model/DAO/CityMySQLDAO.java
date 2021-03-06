package model.DAO;

import model.domain.City;
import model.domain.builders.CityBuilder;
import model.exeptions.PersistExeption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class CityMySQLDAO implements CityDAO {
    private final String readStatement = "SELECT name,ID FROM cities WHERE ID=?";
    private Connection connection;

    public CityMySQLDAO(Connection connection) {
        this.connection = connection;
    }

    public City read(Integer key) throws PersistExeption {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(readStatement);
            preparedStatement.setInt(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            City city = null;
            if (resultSet.next()) {
                city = new CityBuilder()
                        .setName(resultSet.getString("name"))
                        .createCity();
                city.setId(resultSet.getInt("ID"));
            }
            return city;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistExeption();
        }
    }

    public void delete(Integer key) {
        throw new UnsupportedOperationException();
    }

    public Integer create(City city) {
        throw new UnsupportedOperationException();
    }

    public void update(City city) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void setConnection(Connection connection) {

        this.connection = connection;
    }
}
