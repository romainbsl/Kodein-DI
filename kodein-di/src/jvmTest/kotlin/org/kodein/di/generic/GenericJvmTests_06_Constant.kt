package org.kodein.di.generic

import org.kodein.di.DI
import org.kodein.di.erased.DEPRECATED_ERASED_GENERIC_7X
import org.kodein.di.test.FixMethodOrder
import org.kodein.di.test.IPerson
import org.kodein.di.test.MethodSorters
import org.kodein.di.test.Person
import kotlin.test.*

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
class GenericJvmTests_06_Constant {

    @Test
    fun test_00_ConstantBindingGetInstance() {

        val kodein = DI {
            constant(tag = "answer") with 42
        }

        val c: Int by kodein.instance(tag = "answer")
        val answer: Int by kodein.constant()

        assertEquals(42, c)
        assertEquals(42, answer)
    }

    @Test
    fun test_01_ConstantBindingGetProvider() {

        val kodein = DI {
            constant(tag = "answer") with 42
        }

        val c: () -> Int by kodein.provider(tag = "answer")

        assertEquals(42, c())
    }

    @Test
    fun test_02_ConstantBindingGetProviderPolymorphic() {

        val kodein = DI {
            constant(tag = "salomon") with Person("Salomon") as IPerson
        }

        val p: IPerson by kodein.instance(tag = "salomon")
        val salomon: IPerson by kodein.constant()

        assertEquals(Person("Salomon"), p)
        assertEquals(Person("Salomon"), salomon)
    }

}
