import { register, getTeleport } from '@antv/x6-vue-shape'
import PlaneInfoCard from '~@/components/nodes/PlaneInfoCard.vue'
import ColumnInfoCard from '~@/components/nodes/ColumnInfoCard.vue'

export const TeleportContainer = getTeleport()

register({
    shape: 'planeInfoCard',
    width: 700,
    height: 300,
    component: PlaneInfoCard
})

register({
    shape: 'columnInfoCard',
    width: 300,
    height: 500,
    component: ColumnInfoCard
})