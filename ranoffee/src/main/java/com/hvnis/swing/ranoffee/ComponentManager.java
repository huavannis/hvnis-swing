package com.hvnis.swing.ranoffee;

import com.hvnis.swing.core.ComponentCreator;
import com.hvnis.swing.theme.ThemeFactory;
import com.hvnis.swing.theme.ThemeType;

public class ComponentManager {
    private static final ComponentManager INSTANCE = new ComponentManager();
    private final ComponentCreator componentCreator;

    private ComponentManager() {
        componentCreator = new ComponentCreator(new ThemeFactory().getTheme(ThemeType.BLUE));
    }

    public static ComponentManager getInstance() {
        return INSTANCE;
    }

    public ComponentCreator getComponentCreator() {
        return componentCreator;
    }
}
