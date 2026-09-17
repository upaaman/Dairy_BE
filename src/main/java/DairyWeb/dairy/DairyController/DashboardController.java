package DairyWeb.dairy.DairyController;

import DairyWeb.dairy.DairyDTOs.ResponseDTOs.DashboardResDTO;
import DairyWeb.dairy.DairyServices.DashboardService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private DashboardService dashboardService;
    public DashboardController(DashboardService dashboardService){
        this.dashboardService=dashboardService;
    }

    @GetMapping
    public DashboardResDTO getDashboard(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ) {
        return dashboardService.getDashboard(startDate,endDate);
    }

}