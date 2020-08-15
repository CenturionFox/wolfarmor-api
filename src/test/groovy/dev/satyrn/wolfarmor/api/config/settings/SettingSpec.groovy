package dev.satyrn.wolfarmor.api.config.settings

import net.minecraft.nbt.NBTBase
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.common.config.Configuration
import net.minecraftforge.common.config.Property
import spock.lang.Specification
import spock.lang.Unroll

import javax.annotation.Nonnull

@Unroll
class SettingSpec extends Specification {

    def createSetting(Object defaultValue) {
        return new Setting(defaultValue) {
            @Override Object readTag(NBTBase tag) {
                if(tag instanceof  NBTTagCompound) {
                    NBTTagCompound compound = (NBTTagCompound) tag
                    return compound.hasKey('value') ? compound.getString('key') : null
                }
                return null
            }
            @Override NBTBase writeTag(Object value) { return null }
            @Override Property getConfigurationProperty(@Nonnull Configuration config) { return null }
            @Override void loadFromConfiguration(@Nonnull Configuration config) { }
            @Override void saveToConfiguration(@Nonnull Configuration config) { }
            @Override Object parse(String value) { return null }
        }
    }

    def 'Setting should set default value in constructor'() {
        setup:
        def defaultValue = 'default value for setting'
        def setting = createSetting(defaultValue)
        expect:
        defaultValue == setting.defaultValue
    }

    def 'setName should be fluent'() {
        setup:
        def setting = createSetting(1234567890)
        def setting2 = setting.setName('setting name')
        expect:
        setting == setting2
    }

    def 'setName should set the name field'() {
        setup:
        def newName = 'This is the new setting name'
        def setting = createSetting(null)
                .setName(newName)
        expect:
        newName == setting.name
    }

    def 'setCategory should be fluent'() {
        setup:
        def setting = createSetting('heebie-jeebies')
        def setting2 = setting.setCategory('odd words')
        expect:
        setting == setting2
    }

    def 'setCategory should set the category'() {
        setup:
        def category = 'uncles who are your uncles and also named bob'
        def setting = createSetting('you have no uncles named bob').setCategory(category)
        expect:
        category == setting.category
    }

    def 'setValue should be fluent'() {
        setup:
        def setting = createSetting(new Object())
        def setting2 = setting.setValue(13)
        expect:
        setting == setting2
    }

    def 'setValue should set the value field'() {
        setup:
        def newValue = '2 mow 3 plong'
        def setting = createSetting('derp derp derp').setValue(newValue)
        expect:
        newValue == setting.currentValue
    }

    def 'getFullSettingName should get the category and the setting name concatenated with a period'() {
        setup:
        def setting = createSetting('123')
        setting.name = 'name'
        setting.category = 'category'
        expect:
        "${setting.category}.${setting.name}" == setting.getFullName()
    }

    def 'setIsSynchronizedSetting should be fluent'() {
        setup:
        def setting = createSetting('lonely path')
        def setting2 = setting.setSynchronizes(true)
        expect:
        setting2 == setting
    }

    def 'setIsSynchronizedSetting should set isSynchronizedSetting field'() {
        setup:
        def isSynchronizedSetting = true
        def setting = createSetting('wandering path').setSynchronizes(isSynchronizedSetting)
        expect:
        isSynchronizedSetting == setting.synchronizes
    }

    @SuppressWarnings('GroovyAccessibility')
    def 'getIsCurrentlySynchronized should always return false if the isSynchronizedSetting field is set to false'() {
        setup:
        def setting = createSetting('default').setSynchronizes(false)
        setting.readSynchronized(new NBTTagCompound())
        expect:
        !setting.getIsCurrentlySynchronized()
    }

    @SuppressWarnings('GroovyAccessibility')
    def 'getIsCurrentlySynchronized should return the value of the isCurrentlySynchronized field if the isSynchronizedSetting field is set to true'() {
        setup:
        def setting = createSetting('default').setSynchronizes(true)
        setting.readSynchronized(new NBTTagCompound())
        expect:
        setting.isCurrentlySynchronized == setting.getIsCurrentlySynchronized()
    }

    @SuppressWarnings('GroovyAccessibility')
    def 'getSynchronizedValue should return null if the isSynchronizedSetting field is set to false'() {
        setup:
        def setting = createSetting('non-synced').setSynchronizes(false)
        def tag = new NBTTagCompound()
        tag.setString('value', 'should not be synchronized')
        setting.readSynchronized(tag)
        expect:
        setting.getSyncedValue() == null
    }

    @SuppressWarnings('GroovyAccessibility')
    def 'getSynchronizedValue should return the value of synchronizedValue if the isSynchronizedSetting field is set to true'() {
        setup:
        def setting = createSetting('synced').setSynchronizes(true)
        def tag = new NBTTagCompound()
        tag.setString('value', 'should be synchronized')
        setting.readSynchronized(tag)
        expect:
        setting.getSyncedValue() == setting.syncedValue
    }

    @SuppressWarnings('GroovyAccessibility')
    def 'readSynced should set isCurrentlySynchronized'() {
        setup:
        def setting = createSetting('forked path').setSynchronizes(true)
        setting.readSynchronized(new NBTTagCompound())
        expect:
        setting.isCurrentlySynchronized
    }

    def 'readSynchronized should call readTag once'() {
        setup:
        def setting = Spy(createSetting('reads synced').setSynchronizes(true))
        def tag = new NBTTagCompound()
        tag.setString('value', 'synced')
        when:
        setting.readSynchronized(tag)
        then:
        with(setting) {
            1 * readTag(tag)
        }
    }

    def 'writeSynchronized should call writeTag once'() {
        setup:
        def setting = Spy(createSetting('writes synced').setSynchronizes(true).setValue('writes synced'))
        when:
        setting.writeSynchronized()
        then:
        with(setting) {
            1 * writeTag(setting.currentValue)
        }
    }
}
