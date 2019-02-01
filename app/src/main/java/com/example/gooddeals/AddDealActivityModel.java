package com.example.gooddeals;

class AddDealActivityModel {

    public void addDeal(WorkerWithServer.DealCallback dealCallback, Deal deal){
        final WorkerWithServer workerWithServer = new WorkerWithServer();

        workerWithServer.addDeal(dealCallback, deal);
    }
}
