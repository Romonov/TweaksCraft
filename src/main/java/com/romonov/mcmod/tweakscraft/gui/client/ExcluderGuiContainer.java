package com.romonov.mcmod.tweakscraft.gui.client;

import com.romonov.mcmod.tweakscraft.gui.container.ExcluderContainer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ExcluderGuiContainer extends GuiContainer {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation("tweakscraft:textures/gui/gui_excluder.png");

    public ExcluderGuiContainer(ExcluderContainer container) {
        super(container);
        this.xSize = 195;
        this.ySize = 168;
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String title = I18n.format("gui.excluder.title");
        this.fontRenderer.drawString(title, 8, 6, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        this.drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(TEXTURE);
        int offsetX = (this.width - this.xSize) / 2;
        int offsetY = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
    }
}
