/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.utils;

/**
 *
 * @author ADMIN
 */
public class MyAppConstants {

    public class HomeFeatures {

        public static final String HOME_PAGE = "homePage";
        public static final String ERROR_PAGE = "error404";
    }

    public class LoginFeatures {

        public static final String INVALID_PAGE = "loginPage";
        public static final String HOME_PAGE = "home";
    }

    public class LogoutFeatures {

        public static final String LOGIN_PAGE = "loginPage";
    }

    public class RegisterFeatures {

        public static final String LOGIN_PAGE = "loginPage";
        public static final String ERROR_PAGE = "registerPage";
    }

    public class UpdateFeatures {

        public static final String FAIL_PAGE = "viewProfile";
        public static final String SUCCESS_PAGE = "viewProfileAction";
    }

    public class ForgotPasswordFeatures {

        public static final String FAIL_PAGE = "forgotPassword";
        public static final String SUCCESS_PAGE = "enterOtp";
        public static final String RESET_PAGE = "newPassword";
        public static final String WRONG_PAGE = "enterOtp";
        public static final String LOGIN_PAGE = "loginPage";
    }

    public class ViewProfileFeatures {

        public static final String FAIL_PAGE = "error404";
        public static final String SUCCESS_PAGE = "viewProfile";
    }

    public class StartUpFeatures {

        public static final String HOME_PAGE = "home";
        public static final String DEFAULT_PAGE = "home";
    }

    public class ViewProductDetailFeatures {

        public static final String DETAIL_PAGE = "productDetailPage";
        public static final String ERROR_PAGE = "error404";
    }

    public class ShopFeatures {

        public static final String SHOP_PAGE = "shopPage";
    }

    public class ViewProductByCategoryFeatures {

        public static final String SHOP_PAGE = "shopPage";
    }

    public class ManageAccountFeatures {
        public static final String MANAGE_ACCOUNT_PAGE = "adminManageAccount";
        public static final String ERROR_PAGE = "error404";
    }

    public class ShowProductManager {

        public static final String INVALID_PAGE = "homePage";
        public static final String STORE_PAGE = "managerPage";
        public static final String ERROR_PAGE = "error404";
        public static final String EDIT_PAGE = "editPage";

    }

    public class AdminDeleteFeatures {

        public static final String MANAGE_ACCOUNT_PAGE = "manageAccount";
        public static final String ERROR_PAGE = "error404";
    }

    public class AdminEditFeatures {

        public static final String MANAGE_ACCOUNT_PAGE = "manageAccount";
        public static final String ERROR_PAGE = "error404";
    }

    public class SearchFeature {

        public static final String ERROR = "error404";
        public static final String PAGE_CONTROL = "searchPageChange";
        public static final String SUCCESS = "showSearch";
        public static final String SEARCH = "searchAction";
        public static final String SEARCH_PRICE_RANGE = "searchPriceRange";
        public static final String SEARCH_TYPE = "searchType";
        public static final String SEARCH_COLOR = "searchColor";
        public static final String ORDER_BY = "orderBy";
    }

    public class EventFeatures {
        public static final String EVENT_PAGE = "eventPage";
        public static final String DETAIL_PAGE = "eventDetailPage";
    }

    public class EventFlowerFeatures {

        public static final String DETAIL_PAGE = "EventFlowerDetail";
        public static final String ERROR_PAGE = "error404";
    }

    public class ManageEvent {

        public static final String ERROR_PAGE = "error404";
        public static final String VIEW_EVENT_PAGE = "viewEventPage";
        public static final String VIEW_EVENT = "viewEvent";
        public static final String DETAIL_PAGE = "eventDetailPage";
        public static final String MANAGE_EVENT_PAGE = "manageEventPage";
    }

    public class Delivery {

        public static final String ERROR_PAGE = "error404";
        public static final String SHIPPER_ORDER_PAGE = "delivererOrdersPage";
        public static final String SHIPPER_ORDER = "delivererOrders";
        public static final String SHIPPER_DELIVERING = "viewOrdersForDelivery";
        public static final String SHIPPER_DELIVERING_PAGE = "viewOrdersForDeliveryPage";
        public static final String DELIVERY_INFO_PAGE = "deliveryInformationPage";
    }

    public class DashBoardFeatures {

        public static final String DASHBOARD_PAGE = "dashBoard";
        public static final String ERROR_PAGE = "error404";
        public static final String MONTHLY_PAGE = "monthlyBoard";

    }

    public class CartAddItemFeatures {

        public static final String SHOP_VIEW = "shoppingAction";
        public static final String VIEW_CART_PAGE = "cartPage";
        public static final String ERROR_PAGE = "productDetail";
    }

    public class CartFeatures {

        public static final String VIEW_CART_PAGE = "cartPage";
    }

    public class EventCartAddItemFeatures {

        public static final String EVENT_VIEW = "eventDetail";
        public static final String VIEW_ECART_PAGE = "eventCart";
        public static final String ERROR_PAGE = "flowerDetail";
        public static final String CATE_VIEW = "category";
    }

    public class EventCartFeatures {

        public static final String CART_PAGE = "eventCart";
    }

    public class CheckoutFeatures {

        public static final String ERROR_PAGE = "sessionExpired";
        public static final String CHECKOUT = "checkoutPage";
        public static final String CART_PAGE = "eventCart";
    }

    public class PlaceOrderFeatures {

        public static final String CART_PAGE = "eventCart";
        public static final String ERROR_PAGE = "sessionExpired";
        public static final String ORDER_PAGE = "order";
        public static final String BILL_PAGE = "confirmCheckoutPage";
        public static final String ONLINE_PAYMENT = "vnpayCheckout";
        public static final String CHECKOUT_SUCCESS = "checkouts";
        public static final String CHECKOUT_FAIL = "checkout";
    }

    public class ShopCheckoutFeatures {

        public static final String ERROR_PAGE = "sessionExpired";
        public static final String CHECKOUT = "shopCheckoutPage";
        public static final String CART_PAGE = "cartPage";
    }

    public class ShopPlaceOrderFeatures {

        public static final String CART_PAGE = "cartPage";
        public static final String ERROR_PAGE = "sessionExpired";
        public static final String ORDER_PAGE = "orderShop";
        public static final String BILL_PAGE = "confirmShopCheckoutPage";
        public static final String ONLINE_PAYMENT = "vnpayShopCheckout";
        public static final String CHECKOUT_SUCCESS = "shopCheckouts";
        public static final String CHECKOUT_FAIL = "shopCheckout";
    }   
}
