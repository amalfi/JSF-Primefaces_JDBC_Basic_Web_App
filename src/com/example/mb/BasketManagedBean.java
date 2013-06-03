package com.example.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import org.primefaces.event.RowEditEvent;

public class BasketManagedBean {


    private List<Item> items;
    private Item selectedItem;
    private Item[] selectedItems;
    private List<Item> selectedItemsList;
    private SelectItem[] itemNamesOptions;

    public BasketManagedBean() {
        items = new ArrayList<Item>(ItemConverter.items.values());
    }
    
    public String[] getItemNames() {
        return ItemConverter.items.keySet().toArray(new String[0]);
    }

    public SelectItem[] getItemNamesAsOptions() {
        itemNamesOptions = createFilterOptions(ItemConverter.items.keySet().toArray(new String[0]));
        return itemNamesOptions;
    }

    private SelectItem[] createFilterOptions(String[] data) {
        SelectItem[] options = new SelectItem[data.length + 1];

        options[0] = new SelectItem("", "Select");
        for(int i = 0; i < data.length; i++) {
            options[i + 1] = new SelectItem(data[i], data[i]);
        }

        return options;
    }

    public void onEdit(RowEditEvent event) {
        MessageUtil.addInfoMessage("item.edit", ((Item) event.getObject()).getName());
    }

    public void onCancel(RowEditEvent event) {
        MessageUtil.addInfoMessage("item.edit.cancelled", ((Item) event.getObject()).getName());
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public Item[] getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(Item[] selectedItems) {
        this.selectedItems =  selectedItems;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getSelectedCarsList() {
        return  selectedItemsList;
    }

    public void setSelectedItemsList(List<Item> selectedCarsList) {
        this. selectedItemsList =  selectedItemsList;
    }
}
