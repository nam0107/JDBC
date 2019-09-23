/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.util.List;

/**
 *
 * @author hoang
 */
public interface DAO<T> {
    List<T> getAll();
    boolean insert(T data);
    boolean update(T data);
    boolean delete(int id);
}
