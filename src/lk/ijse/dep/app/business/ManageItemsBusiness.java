package lk.ijse.dep.app.business;

import lk.ijse.dep.app.dao.DAOFactory;
import lk.ijse.dep.app.dao.custom.ItemDAO;
import lk.ijse.dep.app.dto.ItemDTO;
import lk.ijse.dep.app.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageItemsBusiness {

    private static ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);

    public static List<ItemDTO> getItems() throws SQLException{
        List<Item> allItems = itemDAO.findAll();
        List<ItemDTO> tmpDTOs = new ArrayList<>();
        for (Item item : allItems) {
            ItemDTO dto = new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
            tmpDTOs.add(dto);
        }
        return tmpDTOs;
    }

    public static boolean createItem(ItemDTO dto) throws SQLException {
        Item item = new Item(dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand());
        return itemDAO.save(item);
    }

    public static boolean updateItem(ItemDTO dto) throws SQLException{
        Item item = new Item(dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand());
        return itemDAO.update(item);
    }

    public static boolean deleteItem(String code) throws SQLException {
        return itemDAO.delete(code);

    }

    public static ItemDTO findItem(String itemCode) throws SQLException {
        Item item = itemDAO.find(itemCode);
        if (item!=null){
            return new ItemDTO(item.getCode(),
                    item.getDescription(),
                    item.getUnitPrice(),
                    item.getQtyOnHand());
        }
        return null;
    }
}
