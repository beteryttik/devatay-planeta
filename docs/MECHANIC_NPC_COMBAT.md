# NPC обороняются

BaseNpcEntity + NpcDefendTask: поиск химер в 16 блоках, стрельба PlasmaBolt (урон 6, отдача) раз в 2 сек.
BaseDefenseManager при волне включает задачи всем NPC зоны, после волны — патруль.