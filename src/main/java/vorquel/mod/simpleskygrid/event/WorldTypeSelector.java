package vorquel.mod.simpleskygrid.event;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import vorquel.mod.simpleskygrid.asm.Mappings;
import vorquel.mod.simpleskygrid.config.SimpleSkyGridConfigReaders;
import vorquel.mod.simpleskygrid.helper.Ref;

public class WorldTypeSelector {

    @SubscribeEvent
    @SuppressWarnings("unused")
    public void changeWorldType(GuiScreenEvent.InitGuiEvent.Post event) {
        if(event.gui instanceof GuiCreateWorld) {
            if(SimpleSkyGridConfigReaders.skyGridDefault) {
            	System.out.println(Mappings.selectedIndex);
                ReflectionHelper.setPrivateValue(GuiCreateWorld.class, (GuiCreateWorld) event.gui, Ref.worldType.getWorldTypeID(), Mappings.selectedIndex);
                for(Object object : event.buttonList) {
                    GuiButton button = (GuiButton) object;
                    if(button.id != 5)
                        continue;
                    button.displayString = I18n.format("selectWorld.mapType") + " " + I18n.format(Ref.worldType.getTranslateName());
                    break;
                }
            }
        }
    }

}
