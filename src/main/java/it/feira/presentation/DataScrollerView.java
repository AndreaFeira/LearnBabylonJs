package it.feira.presentation;

import it.feira.business.entity.Asta;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
 
/**
 *
 * @author Andrea Feira
 */
@ManagedBean
@ViewScoped
public class DataScrollerView implements Serializable {
     
    private List<Asta> listaAste;
         
//    @ManagedProperty("#{carService}")
//    private CarService service;
//     
//    @PostConstruct
//    public void init() {
//        cars = service.createCars(100);
//    }
// 
//    public List<Car> getCars() {
//        return cars;
//    }
// 
//    public void setService(CarService service) {
//        this.service = service;
//    }
}
