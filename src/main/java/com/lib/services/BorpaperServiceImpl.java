package com.lib.services;

import com.lib.beans.Borpaper;
import java.util.List;
public interface BorpaperServiceImpl {
    public Borpaper getBorpaperById (String id);
    public List<Borpaper> getBorpapersByTime (String lDay, String rDay);
    public List<Borpaper> getBorpaperByTime (String lDay);
}
