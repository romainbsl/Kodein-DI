package org.kodein.di.internal

import org.kodein.di.DKodein
import org.kodein.di.KodeinContainer
import org.kodein.di.KodeinContext

@Deprecated("Deprecated in favor of a new API", replaceWith = ReplaceWith("DirectDIImpl"), level = DeprecationLevel.WARNING)
internal actual class DKodeinImpl actual constructor(container: KodeinContainer, context: KodeinContext<*>) : DKodeinBaseImpl(container, context), DKodein
