package Start;

import bll.DeliveryService;
import bll.MenuItem;
import bll.Order;
import bll.User;
import presentation.controller.LogInController;
import presentation.view.Employee.*;
import presentation.view.Log.LogInView;

import java.lang.invoke.ConstantCallSite;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Start {

    private static DeliveryService deliveryService;

    public static void main(String[] args) {

        LogInController logInController = new LogInController();
        LogInView logInView = new LogInView();
        logInController.Initialize(logInView);

        deliveryService = new DeliveryService();
    }

    public static DeliveryService getDeliveryService() {
        return deliveryService;
    }
}
