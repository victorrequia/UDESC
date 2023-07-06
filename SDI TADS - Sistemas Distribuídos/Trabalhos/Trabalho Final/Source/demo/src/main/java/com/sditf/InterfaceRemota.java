package com.sditf;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfaceRemota extends Remote {
    public String echo(String mensagem) throws RemoteException;
    public ArrayList<String> getListOfMsg() throws RemoteException;
    public boolean keepAlive() throws RemoteException;
}