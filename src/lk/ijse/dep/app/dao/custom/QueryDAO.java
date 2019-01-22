package lk.ijse.dep.app.dao.custom;

import lk.ijse.dep.app.dao.SuperDAO;
import lk.ijse.dep.app.entity.CustomEntity;

import java.sql.SQLException;
import java.util.List;

public interface QueryDAO extends SuperDAO {

    List<CustomEntity> findOrderDetailsWithItemDescriptions(String orderId)throws SQLException;

    List<CustomEntity> findAllOrdersWithCustomerNameAndTotal() throws SQLException;

}
