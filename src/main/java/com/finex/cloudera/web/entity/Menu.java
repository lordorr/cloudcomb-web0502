package com.finex.cloudera.web.entity;

import java.util.List;

/**
 * Created by lordorr on 2017/4/11.
 */
public class Menu {
    int menuId;      //id
    String menuName; //显示名称
    int pId;      //父菜单
    String menuUrl;     //url
    String menuOrder;   //菜单排序
    String menuIcon;    //图标
    String menuType;    //菜单类型
    int menuState;
    List<SubMenu> subMenu;

    public List<SubMenu> getSubMenu() {
        return subMenu;
    }

    public Menu(int menuId, String menuName, int pId, String menuUrl, String menuOrder, String menuIcon, String menuType, int menuState, List<SubMenu> subMenu) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.pId = pId;
        this.menuUrl = menuUrl;
        this.menuOrder = menuOrder;
        this.menuIcon = menuIcon;
        this.menuType = menuType;
        this.menuState = menuState;
        this.subMenu = subMenu;
    }

    public void setSubMenu(List<SubMenu> subMenu) {
        this.subMenu = subMenu;
    }

    public Menu() {
    }

    public Menu(int menuId, String menuName, int pId, String menuUrl, String menuOrder, String menuIcon, String menuType, int menuState) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.pId = pId;
        this.menuUrl = menuUrl;
        this.menuOrder = menuOrder;
        this.menuIcon = menuIcon;
        this.menuType = menuType;
        this.menuState = menuState;
    }

    @Override
    public String toString() {
        return "SubMenu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", pId=" + pId +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuOrder='" + menuOrder + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuType='" + menuType + '\'' +
                ", menuState=" + menuState +
                '}';
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(String menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public int getMenuState() {
        return menuState;
    }

    public void setMenuState(int menuState) {
        this.menuState = menuState;
    }
}
