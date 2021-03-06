package vorquel.mod.simpleskygrid;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkCheckHandler;
import cpw.mods.fml.relauncher.Side;
import vorquel.mod.simpleskygrid.helper.Ref;
import vorquel.mod.simpleskygrid.proxy.Proxy;

import java.util.Map;

@Mod(modid = Ref.MOD_ID, name = "Simple Sky Grid", version = "@MOD_VERSION@")
public class SimpleSkyGrid {

    @Mod.Instance(Ref.MOD_ID)
    @SuppressWarnings("unused")
    public static SimpleSkyGrid instance;
    @SidedProxy(clientSide = "vorquel.mod.simpleskygrid.proxy.ProxyClient", serverSide = "vorquel.mod.simpleskygrid.proxy.Proxy")
    public static Proxy proxy;

    @Mod.EventHandler
    @SuppressWarnings("unused")
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }

    @Mod.EventHandler
    @SuppressWarnings("unused")
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }

    @Mod.EventHandler
    @SuppressWarnings("unused")
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }

    @Mod.EventHandler
    @SuppressWarnings("unused")
    public void serverLoad(FMLServerStartingEvent event) {
        proxy.serverLoad(event);
    }

    @NetworkCheckHandler
    @SuppressWarnings("unused")
    public boolean checkRemoteVersion(Map<String,String> mods, Side otherSide) {
        return !mods.containsKey(Ref.MOD_ID) || mods.get(Ref.MOD_ID).equals("@MOD_VERSION@");
    }
}
