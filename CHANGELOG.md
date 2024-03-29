### 2024-03-29 - 2.1.1.2.beta

- fixed item handler for coin press
- fixed netherite ingot and endonian ingot tags
- fixed translation error for nether gold coin bag
- edited currency materials tag

### 2024-03-20 - 2.1.1.1.beta

- fixed patron coin item use on right click function
- cleaned up code
- minor fixes to mod trade types

### 2024-03-11 - 2.1.1.0.beta

- updated build dependencies and fixed missing texture
- added advancements for equipping a lucky coin and equipping a wallet
  - both reward the player with an additional respective curios slot
- added leather item tag to the textiles tags
- added a bundle recipe using leather tag and string tag

### 2024-03-10 - 2.1.0.2.beta

- fixed crash on server when generating new Numismatist trades

### 2024-03-05 - 2.1.0.1.beta

- added crafting table recipes to repair collectible coins with nuggets

### 2024-02-26 - 2.1.0.0.beta

- split loot table gen files into smaller files to make future edits easier
- converted numismatist trades to use loot tables
  - this brings back seasonal coin offers and requests
- added additional loot condition in collectible coin loot tables to check dimension
- collectible coin chest loot tables now fully randomized instead of based on biome or structure
- collectible coin mob/potion effects applied on item use only
- collectible coins no longer equip on item use

### 2024-01-15 - 2.0.0.2.beta

- added missing translations for custom effects

### 2024-01-04 - 2.0.0.1.beta

- updated build gradle and forge version

### 2024-01-03 - 2.0.0.beta

- [BREAKING] completely overhauled collectible coin effects and attribute modifiers
  - attempting to re-balance the coins so that none of them are overpowered and reduce redundancy
- updated mixin class names to better reflect what they do
- fox coins and arthropod coins properly allow players to walk through sweet berry bushes and cobwebs respectively
  without getting stuck

### 2023-12-30 - 1.9.5.beta

- updated advancements
- removed unused loot item conditions
- updated season checks to be easier to access across the mod
- added JEI support

### 2023-12-22 - 1.9.2.beta

- updated build dependencies
- added friendship bracelets
  - these bracelets are linked to a single player
    - when used by the linked player, the bracelet teleports the player to their spawn point
    - when used by a player other than the linked player, the bracelet teleports the player to the linked player
      - teleports across dimensions, permits teleportation into private player areas (unless some other mod blocks this)
        - players should only give out their linked bracelets to those they trust
        - restricting teleportation to one dimension isn't practical
          - there's no way for me to know all present and future modded dimensions out there in the community
          - there's no way for me to know which dimension modpack makers and server owners choose to have players start
            in
            - yes, usually this is the overworld, but there are mods that allow for a different option
          - different bracelets for different dimensions would be a hassle for everyone
            - who wants a different bracelet for each dimension just to teleport to their friend?
              - start multiplying that by the number of friends you have and this becomes an inventory nightmare
            - this also means the dimension would be hardcoded to the bracelet
              - this means mod compatibility would be severely limited
    - these bracelets are not repairable and by default are only obtainable via crafting

### 2023-12-17 - 1.9.1.beta

- added chocolate coins for each holiday coin introduced so far
- added crafting table recipes for chocolate coins
  - these recipes use mostly tagged ingredients along with just vanilla items to increase mod compatibility

### 2023-12-17 - 1.9.0.beta

- [BREAKING] removed the enum classes from the seasonal loot checks
  - this increases the variance of coins found, especially during holiday events
  - this also brings the loot tables in line with what I had originally envisioned

### 2023-12-16 - 1.8.0.beta

- this is a big change, but shouldn't break any internal code:
- all attribute modifiers on collectible coins are now at fixed values
- all effects on collectible coins have been set to a fixed amplifier of 0 - setting all effects to level 1
  - none of the coins are dependent on difficulty level anymore
  - yes, this means all the collectible coins have been nerfed to some extent, but especially the boss coins
    - this is a result of our personal play testing while using an additional charm slot that isn't provided by default
      but can be added in the curios config files
      - the biggest and most notable issue was that wearing two Warden coins made a player invincible even in hard
        mode,and even while fighting the Warden, so we're trying to fix that because we don't want something so insanely
        overpowered in this mod - even just one Warden coin is overpowered
        - so please bear with us as we use this coin as our means to measure our cap and scale everything back
          accordingly and this might take us some time
- it's now possible to salvage the copper, iron, gold, and netherite collectible coins by smelting or blasting them into
  nuggets
  - holiday and patron coins can be salvaged into endonian nuggets via smelting or blasting
  - the collectible coins continue to remain uncraftable

### 2023-12-16 - 1.7.10.beta

- reduced entity coin drops from non-boss mobs to 10%
  - boss coins remain set at 100% drop by default
- attempting to re-balance boss coin effects (mainly nerfing the Warden coins)

### 2023-12-14 - 1.7.9.beta

- added missing iceologer_types tag
- updated to Forge 43.3.5
- updated dependencies