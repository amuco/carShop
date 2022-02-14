package com.carseller.cars.tasks;

import com.carseller.cars.XmlConverter;
import com.carseller.cars.domain.engine.EngineService;
import com.carseller.cars.domain.model.ModelService;
import com.carseller.cars.domain.wheels.WheelsService;
import lombok.AllArgsConstructor;
import org.w3c.dom.NodeList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;



@Slf4j
@Service
@AllArgsConstructor
public class FordIngesterTask {


  private EngineService engineService;
  private ModelService modelService;
  private WheelsService wheelsService;
  private XmlConverter xmlConverter;
  private static final String model="MODEL";
  private static final String engine="ENGINE";
  private static final String wheels="WHEELS";


  @Scheduled(cron = "${cars.ford.ingester.runCron}")
  public void ingestFile() {
         log.info("Getting node lists");
      NodeList list= xmlConverter.getNodeList(model);
      NodeList engineList= xmlConverter.getNodeList(engine);
      NodeList wheelList= xmlConverter.getNodeList(wheels);
      wheelsService.saveFromXmL(wheelList);
      engineService.saveEngineFromXml(engineList);
      modelService.saveModelFromXml(list);
  }




}
