package com.bogdan_yanushkevich.javacore.crud.view;

import com.bogdan_yanushkevich.javacore.crud.controller.SkillController;
import com.bogdan_yanushkevich.javacore.crud.repository.impl.GsonSkillRepositoryImpl;

public class Static {

    public static SkillView skillView = new SkillView();
    public static GsonSkillRepositoryImpl skillRepository = new GsonSkillRepositoryImpl();
    public static SkillController skillController = new SkillController();
}
