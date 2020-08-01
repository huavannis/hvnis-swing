package com.hvnis.swing.theme;

import com.hvnis.swing.theme.impl.BlueTheme;
import com.hvnis.swing.theme.impl.OrangeTheme;

/**
 * @author hvnis
 */
public final class ThemeFactory {
	public ITheme getTheme(ThemeType themeType) {
		if (themeType != null) {
			switch (themeType) {
				case BLUE :
					return new BlueTheme();
				case ORANGE :
					return new OrangeTheme();
			}
		}
		return new BlueTheme();
	}
}