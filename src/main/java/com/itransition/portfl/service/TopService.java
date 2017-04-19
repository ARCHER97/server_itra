package com.itransition.portfl.service;

import com.itransition.portfl.model.notdbmodel.Top;

import java.util.ArrayList;

/**
 * @author Kulik Artur
 */
public interface TopService {
    public ArrayList<Top> findTop(Integer col);
}
