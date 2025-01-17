package oblivion.content;

import arc.struct.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.blocks.defense.turrets.*;

import static mindustry.Vars.*;
import static mindustry.content.TechTree.*;

public class LamoniTechTree {
	public void load() {
		OblivionPlanets.lamoni.techTree = nodeRoot("lamoni", OblivionBlocks.coreVillage, true, () -> {
			nodeProduce(OblivionResources.niobium, () -> {
				nodeProduce(Items.sand, () -> {
					nodeProduce(OblivionResources.hafnium, () -> {});
				});
				nodeProduce(Liquids.water, () -> {});
			});

			node(OblivionBlocks.mantlePulverizer, () -> {
				node(OblivionBlocks.hafniumSmelter, () -> {});
			});

			node(OblivionBlocks.spread, () -> {
				node(OblivionBlocks.reaction, () -> {});
			});

			node(OblivionBlocks.niobiumDuct, () -> {});

			node(OblivionBlocks.niobiumWall, () -> {
				node(OblivionBlocks.largeNiobiumWall, () -> {
					node(OblivionBlocks.hugeNiobiumWall, () -> {});
				});
			});
		});
	}
}
