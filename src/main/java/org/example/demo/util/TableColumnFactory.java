package org.example.demo.util;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.demo.models.Column;

import java.lang.reflect.Field;

public class TableColumnFactory {

    /**
     * Dynamically creates columns for a TableView based on the fields of the provided entity.
     * @param entity The entity used to derive columns from fields.
     * @param table The TableView to which columns will be added.
     */
    public static <T> void createColumns(T entity, TableView<T> table) {
        table.getColumns().clear();  // Clear any existing columns

        Field[] fields = entity.getClass().getDeclaredFields();  // Get all fields of the entity
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);  // Check if the field is annotated with @Column
            if (column != null) {
                // Create a new TableColumn with the column's name
                TableColumn<T, ?> tableColumn = new TableColumn<>(column.name());
                // Set the cell value factory to map the field name to the column
                tableColumn.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
                // Add the created column to the TableView
                table.getColumns().add(tableColumn);
            }
        }
    }
}
