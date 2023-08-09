package soulcoding.chat;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class Chat extends JavaPlugin implements Listener {

    private Map<Player, Integer> dirtyWordCount = new HashMap<>();
    private Inventory enchantmentMenu;
    private Map<Player, Long> mutedPlayers = new HashMap<>();

    @Override
    public void onEnable() {
        getLogger().info("Chat plugin enabled!");
        getServer().getPluginManager().registerEvents(this, this);
        createEnchantmentMenu();
    }

    @Override
    public void onDisable() {
        getLogger().info("Chat plugin disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("gaxe1")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("yourplugin.gaxe1")) {
                    ItemStack diamondPickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
                    ItemMeta meta = diamondPickaxe.getItemMeta();
                    meta.addEnchant(Enchantment.DIG_SPEED, 10, true);
                    meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
                    meta.addEnchant(Enchantment.DURABILITY, 10, true);
                    meta.addEnchant(Enchantment.MENDING, 10, true);
                    diamondPickaxe.setItemMeta(meta);
                    player.getInventory().addItem(diamondPickaxe);
                    player.sendMessage(ChatColor.GREEN + "You have received a diamond pickaxe with enchantment level 10!");
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "This command can only be executed by a player!");
            }
            return true;
        }
        if (command.getName().equalsIgnoreCase("gfm")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.getName().equalsIgnoreCase("soul")) {
                    player.openInventory(enchantmentMenu);
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "This command can only be executed by a player!");
            }
            return true;
        }
        if (command.getName().equalsIgnoreCase("gsword2")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("yourplugin.gsword2")) {
                    ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
                    ItemMeta meta = diamondSword.getItemMeta();
                    meta.setDisplayName(ChatColor.AQUA + "Diamond Sword");
                    diamondSword.setItemMeta(meta);
                    diamondSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
                    diamondSword.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
                    diamondSword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 10);
                    diamondSword.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
                    diamondSword.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
                    player.getInventory().addItem(diamondSword);
                    player.sendMessage(ChatColor.GREEN + "You have received a diamond sword with enchantment level 10!");
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "This command can only be executed by a player!");
            }
            return true;
        }
        if (command.getName().equalsIgnoreCase("gpp")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("yourplugin.gpp")) {
                    ItemStack enchantedGoldenApple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 64);
                    player.getInventory().addItem(enchantedGoldenApple);
                    player.sendMessage(ChatColor.GREEN + "You have received 64 enchanted golden apples!");
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "This command can only be executed by a player!");
            }
            return true;
        }
        if (command.getName().equalsIgnoreCase("gbook")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("yourplugin.gbook")) {
                    ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
                    EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
                    meta.addStoredEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
                    meta.addStoredEnchant(Enchantment.DURABILITY, 10, true);
                    meta.addStoredEnchant(Enchantment.DIG_SPEED, 10, true);
                    enchantedBook.setItemMeta(meta);
                    player.getInventory().addItem(enchantedBook);
                    player.sendMessage(ChatColor.GREEN + "You have received an enchanted book with enchantment level 10!");
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "This command can only be executed by a player!");
            }
            return true;
        }
        if (command.getName().equalsIgnoreCase("gsword1")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("yourplugin.gsword1")) {
                    ItemStack specialSword = new ItemStack(Material.WOODEN_SWORD);
                    ItemMeta meta = specialSword.getItemMeta();
                    meta.setDisplayName(ChatColor.RED + "Soul Sword");
                    List<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GRAY + "======[Description]======");
                    lore.add(ChatColor.GRAY + "The fallen petals are not heartless");
                    lore.add(ChatColor.GRAY + "They turn into spring mud to protect the flowers");
                    lore.add(ChatColor.GRAY + "======[Ability]=======");
                    lore.add(ChatColor.GRAY + "Provides 100% protection");
                    lore.add(ChatColor.GRAY + "Destroys opponent's armor and off-hand when attacking");
                    meta.setLore(lore);
                    meta.setUnbreakable(true);
                    specialSword.setItemMeta(meta);
                    specialSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
                    specialSword.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 10);
                    specialSword.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 10);
                    specialSword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 10);
                    specialSword.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
                    specialSword.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
                    specialSword.addUnsafeEnchantment(Enchantment.MENDING, 1);
                    player.getInventory().addItem(specialSword);
                    player.sendMessage(ChatColor.GREEN + "You have received a special sword!");
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "This command can only be executed by a player!");
            }
            return true;
        }
        if (command.getName().equalsIgnoreCase("gm")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.getName().equalsIgnoreCase("soul")) {
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("creative")) {
                            player.setGameMode(GameMode.CREATIVE);
                            player.sendMessage(ChatColor.GREEN + "You have switched to creative mode!");
                        } else if (args[0].equalsIgnoreCase("survival")) {
                            player.setGameMode(GameMode.SURVIVAL);
                            player.sendMessage(ChatColor.GREEN + "You have switched to survival mode!");
                        } else {
                            player.sendMessage(ChatColor.RED + "Invalid option!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "Usage: /gm [creative/survival]");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "This command can only be executed by a player!");
            }
            return true;
        }
        return false;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        String[] words = message.split(" ");
        for (String word : words) {
            if (isDirtyWord(word) || containsBlockedSymbols(word)) {
                if (!mutedPlayers.containsKey(player)) {
                    // Mute the player for 1 minute (60 seconds)
                    mutedPlayers.put(player, System.currentTimeMillis() + (60 * 1000));
                    player.sendMessage(ChatColor.RED + "You have been muted for 1 minute!");
                } else {
                    // Player is already muted, check if the mute duration has expired
                    long muteDuration = mutedPlayers.get(player);
                    if (System.currentTimeMillis() >= muteDuration) {
                        // Unmute the player
                        mutedPlayers.remove(player);
                        player.sendMessage(ChatColor.GREEN + "You have been unmuted!");
                    }
                }
                getServer().getConsoleSender().sendMessage(ChatColor.RED + "Player " + player.getName() + " said a dirty word!");
                event.setCancelled(true); // Cancel the player's chat message
                break;
            }
        }
    }


    private boolean containsBlockedSymbols(String word) {
        String blockedSymbols = " ./';[]-=)(*&^%$#@!~><| \n 《》。，/？；‘{}【】-=——+~/。，‘；【】=-·~~!@#$%^&*()、|";
        for (char symbol : blockedSymbols.toCharArray()) {
            if (word.contains(String.valueOf(symbol))) {
                return true;
            }
        }
        return false;
    }

    private boolean isDirtyWord(String word) {
        List<String> dirtyWords = Arrays.asList(
                "傻逼"
        );
        return dirtyWords.contains(word.toLowerCase());
    }

    private void createEnchantmentMenu() {
        enchantmentMenu = getServer().createInventory(null, 9, ChatColor.GREEN + "Enchantment Menu");

        List<String> enchantments = Arrays.asList(
                "Sharpness", "Smite", "Bane of Arthropods", "Efficiency", "Power", "Protection", "Fire Protection", "Feather Falling", "Blast Protection", "Projectile Protection", "Respiration", "Aqua Affinity", "Depth Strider",
                "Soul Speed", "Sneakiness", "Looting", "Sweeping Edge", "Unbreaking", "Luck of the Sea", "Thorns", "Frost Walker", "Binding Curse", "Silk Touch", "Loyalty", "Riptide", "Quick Charge", "Frost Aspect", "Knockback",
                "Fire Aspect", "Punch", "Binding Curse", "Efficiency", "Flame", "Infinity", "Channeling", "Multishot", "Mending", "Vanishing Curse"
        );

        for (String enchantment : enchantments) {
            ItemStack enchantmentBook = new ItemStack(Material.ENCHANTED_BOOK);
            ItemMeta meta = enchantmentBook.getItemMeta();
            meta.setDisplayName(ChatColor.YELLOW + "Enchantment Book");
            meta.setLore(Collections.singletonList(ChatColor.GRAY + enchantment + " x"));
            enchantmentBook.setItemMeta(meta);

            enchantmentMenu.addItem(enchantmentBook);
        }
    }
}