/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.searchProduct;

import florastore.DeliveryOrder.DeliverDTO;
import florastore.searchProduct.ProductDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ServiceLayer {

    public void sortInOrder(List<ProductDTO> listSort, boolean ascending) {
        if (ascending) {
            Collections.sort(listSort, Comparator.comparingInt((value) -> value.getProductPrice()));
        } else {
            Collections.sort(listSort, Comparator.comparingInt(ProductDTO::getProductPrice).reversed());
        }
    }

    public List<String> chooseColor(List<ProductDTO> list) {
        String[] defaultColor = {"multi-colored", "red", "blue", "white", "orange", "magenta",
            "yellow", "pink", "purple", "brown", "green", "black"};

        List<String> result = new ArrayList<>();
        List<ProductDTO> copy = new ArrayList<>(list);

        result.add("All type");
        for (int i = 0; i < defaultColor.length; i++) {
            boolean flag = false;
            for (int j = 0; j < copy.size(); j++) {
                if (copy.get(j).getProductDetail().toLowerCase().contains(defaultColor[i])) {
                    flag = true;
                    copy.remove(j);
                }
            }
            if (flag) {
                result.add(defaultColor[i]);
            }
        }
        if (copy.size() != 0) {
            result.add("Other");
        }
        return result;
    }

    public List<ProductDTO> getOtherColor(List<ProductDTO> list) {
        String[] defaultColor = {"red", "blue", "white", "orange", "magenta",
            "yellow", "pink", "purple", "brown", "green", "black"};
        List<ProductDTO> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            boolean flag = false;
            for (int j = 0; j < defaultColor.length; j++) {
                if (list.get(i).getProductDetail().toLowerCase().contains(defaultColor[j])) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                result.add(list.get(i));
            }
        }

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getProductDetail().toLowerCase().contains("multi")
                    && result.get(i).getProductDetail().toLowerCase().contains("color")) {
                result.remove(i);
                i--;
            }
        }
        return result;
    }

    public List<ProductDTO> getSingleColor(List<ProductDTO> list, String color) {
        List<ProductDTO> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductDetail().toLowerCase().contains(color.toLowerCase())) {
                result.add(list.get(i));
            }
        }
        if ("red".equals(color.toLowerCase())) {
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i).getProductDetail().toLowerCase().contains("multi")
                        && result.get(i).getProductDetail().toLowerCase().contains("color")) {
                    result.remove(i);
                    i--;
                }
            }
        }
        return result;
    }

    public List<ProductDTO> getMultyColor(List<ProductDTO> list) {
        List<ProductDTO> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductDetail().toLowerCase().contains("multi")
                    && list.get(i).getProductDetail().toLowerCase().contains("color")) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public List<ProductDTO> getNewProduct(List<ProductDTO> list) {              //get 3 latest product
        List<ProductDTO> getNew = new ArrayList<>();
        for (int i = list.size(); i >= list.size() - 4; i--) {
            getNew.add(list.get(i - 1));
        }
        return getNew;
    }

    public int[] getCategories(List<ProductDTO> list) {
        int total = 0;
        int fresh = 0;
        int pot = 0;
        int dry = 0;
        int other = 0;

        for (ProductDTO categories : list) {

            if ("Hoa ly".equals(categories.getProductType())) {
                fresh++;
            } else if ("Hoa hồng".equals(categories.getProductType())) {
                pot++;
            } else if ("Hoa hướng dương".equals(categories.getProductType())) {
                dry++;
            } else {
                other++;
            }
            total++;
        }

        return new int[]{total, fresh, pot, dry, other};
    }

    public List<ProductDTO> getNine(List<ProductDTO> list, int[] range) {        //get X product in page N
        List<ProductDTO> result = new ArrayList<>();
        int addCounter = 1;
        for (ProductDTO inPage : list) {
            if (range[0] <= addCounter && addCounter <= range[1]) {
                result.add(inPage);
            }
            addCounter++;
        }
        return result;
    }

    public List<DeliverDTO> getSeven(List<DeliverDTO> list, int[] range) {        //get X product in page N
        List<DeliverDTO> result = new ArrayList<>();
        int addCounter = 1;
        for (DeliverDTO inPage : list) {
            if (range[0] <= addCounter && addCounter <= range[1]) {
                result.add(inPage);
            }
            addCounter++;
        }
        return result;
    }
    
    public int getPage(String pageIsActive, String goBack, String goForward) {
        int page = 0;
        if (pageIsActive == null) {
            page = 1;                                                       //lần đầu in ra sản phẩm pageNumber mặc định luôn là 1
        } else {                                                            //nếu chuyển qua trang 2, 3, ... thì pageNumber đã ko còn là null
            if (goBack != null) {
                page = Integer.parseInt(pageIsActive);
                page--;
            } else if (goForward != null) {
                page = Integer.parseInt(pageIsActive);
                page++;
            } else {
                page = Integer.parseInt(pageIsActive);
            }
        }
        return page;
    }

    public int getPage(double list, int count) {                                           //thanh chuyển trang << 1 2 3 4 >>
        double pageSize = Math.ceil(list / count);
        return (int) pageSize;
    }

    public int[] getPageRange(int page, int count) {                                       //lấy phạm vi sản phẩm ở trang 1, 2, ...

        // Tìm 2 đầu vị trí xuất sản phẩm
        int start = (page - 1) * count + 1;
        int end = page * count;

        return new int[]{start, end};
    }

    public String checkPagination(String pageIsActive, String goBack, String goForward) {       //kiểm tra user có chuyển trang không
        if (pageIsActive == null && goBack != null) {
            pageIsActive = goBack;
        } else if (pageIsActive == null && goForward != null) {
            pageIsActive = goForward;
        } 
        return pageIsActive;
    }
}
