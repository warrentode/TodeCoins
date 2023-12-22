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

### 2023-12-03 - 1.7.8.beta

- fixed clearing ender infection with the endermite coin set

### 2023-11-30 - 1.7.7.beta

- corrected holiday checks with the Serene Seasons integration
- fixed translation key for Zombified Piglin Coin Set advancement

### 2023-11-25 - 1.7.6.beta

- added optional compat for unusual end mod
  - endermite coin set should remove ender infection

### 2023-11-25 - 1.7.5.beta

- collectible coin drops from entities work correctly again
- removed a duplicate set of trades from the banker

### 2023-11-25 - 1.7.4.beta

- updated loot tables
- removed a duplicate set of trades from the banker

### 2023-11-22 - 1.7.2.beta

- updated loot tables for collectible coin entity drops
- fixed endonian coin chest loot
- added missing translations
- fixed underwater coin effects

### 2023-11-17 - 1.7.1.beta

- completely revamped the advancements for the collectible coins
- readjusted drop rates for the entity coins
- added missing translations, fixed incorrect translations