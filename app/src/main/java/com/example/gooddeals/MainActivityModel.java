package com.example.gooddeals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivityModel {

    Collection<Deal> dealList = null;

    public void getAllDeals(WorkerWithServer.DealsCallback callback){

        final WorkerWithServer workerWithServer = new WorkerWithServer();

        workerWithServer.start(callback);

//        dealList = workerWithServer.getDealList();


        //return workerWithServer.getDealList();
    }

//    public Collection<Deal> getDealList(){
//
//        return this.dealList;
//    }

    /*public List<Deal> getDealList(){
        return dealList;
    }*/
}
