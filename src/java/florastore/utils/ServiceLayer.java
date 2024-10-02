/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.utils;

import florastore.searchProduct.ProductDTO;
import java.util.ArrayList;
import java.util.List;

public class ServiceLayer {

    public int getPage(int page, String pageIsActive, String goBack, String goForward) {
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

    public List<ProductDTO> getNewProduct(List<ProductDTO> list) {              //get 3 latest product
        List<ProductDTO> getNew = new ArrayList<>();
        for (int i = list.size(); i >= list.size() - 4; i--) {
            getNew.add(list.get(i - 1));
        }
        return getNew;
    }

    public int[] getCategories(List<ProductDTO> list) {
        int fresh = 0;
        int pot = 0;
        int dry = 0;
        int other = 0;

        for (ProductDTO categories : list) {
            if (categories != null && categories.getProductType() != null) {
                if ("Fresh Flower".equals(categories.getProductType())) {
                    fresh++;
                } else if ("Potted Plant".equals(categories.getProductType())) {
                    pot++;
                } else if ("Dried Flower".equals(categories.getProductType())) {
                    dry++;
                } else {
                    other++;
                }
            } else {
                other++;
            }
        }

        return new int[]{fresh, pot, dry, other};
    }

    public List<ProductDTO> getNine(List<ProductDTO> list, int[] range) {        //get nine product in page N
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

    public int getPage(double list) {                                           //thanh chuyển trang << 1 2 3 4 >>
        double pageSize = Math.ceil(list / 12);
        return (int) pageSize;
    }

    public int[] getPageRange(int page) {                                       //lấy X sản phẩm ở trang 1, 2, ...
        // Số sản phẩm trên mỗi trang
        int itemsPerPage = 12;

        // Tìm 2 đầu vị trí xuất sản phẩm
        int start = (page - 1) * itemsPerPage + 1;
        int end = page * itemsPerPage;

        return new int[]{start, end};
    }

    public String checkPagination(String pageIsActive, String goBack, String goForward) {
        if (pageIsActive == null && goBack != null) {
            pageIsActive = goBack;
        } else if (pageIsActive == null && goForward != null) {
            pageIsActive = goForward;
        }
        return pageIsActive;
    }
}
