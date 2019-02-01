package com.example.gooddeals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivityModel {

    Collection<Deal> dealList = null;

    public void getAllDeals(WorkerWithServer.DealsCallback callback){

        final WorkerWithServer workerWithServer = new WorkerWithServer();

        workerWithServer.start(callback);

    }

    public void loginUser(WorkerWithServer.UserCallback callback, UserInfo userInfo){

        final WorkerWithServer workerWithServer = new WorkerWithServer();

        workerWithServer.loginUser(callback, userInfo);

    }

    public void executeDeal(String id, User m_user, WorkerWithServer.UserCallback userCallback) {

        final WorkerWithServer workerWithServer = new WorkerWithServer();

        workerWithServer.executeDeal(userCallback, id, m_user);
    }

    public void deleteDeal(WorkerWithServer.DealCallback dealCallback, String id) {

        final WorkerWithServer workerWithServer = new WorkerWithServer();

        workerWithServer.deleteDeal(dealCallback, id);
    }

//    public Collection<Deal> getDealList(){
//
//        return this.dealList;
//    }

    /*public List<Deal> getDealList(){
        return dealList;
    }*/
}
