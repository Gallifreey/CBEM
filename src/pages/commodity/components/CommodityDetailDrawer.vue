<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <a-drawer v-model:open="openE" width="60%" title="商品审阅">
    <div class="info-panel">
      <div class="immerse-pic-container">
        <img class="immerse-pic" src="https://tse1-mm.cn.bing.net/th/id/OIP-C.IP6ohexuacra5vvG21olCgHaE7?w=257&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"/>
        <div class="img-mask">
          <div class="commodity-shortcut">
            <a-space direction="vertical">
              <span class="commodity-name">足球</span>
              <span class="commodity-brand">BRAND</span>
            </a-space>
          </div>
        </div>
      </div>
      <div class="immerse-info-bar">
        <div class="immerse-info-bar-unit">
          <div class="immerse-info-bar-icon">
            <CarOutlined />
          </div>
          <div class="immerse-info-bar-content">
            <div class="immerse-info-bar-title">
              递送方式
            </div>
            <div class="immerse-info-bar-value">
              快递
            </div>
          </div>
        </div>
        <div class="immerse-info-bar-unit">
          <div class="immerse-info-bar-icon">
            <BankOutlined />
          </div>
          <div class="immerse-info-bar-content">
            <div class="immerse-info-bar-title">
              原产地
            </div>
            <div class="immerse-info-bar-value">
              本地
            </div>
          </div>
        </div>
        <div class="immerse-info-bar-unit">
          <div class="immerse-info-bar-icon">
            <TableOutlined />
          </div>
          <div class="immerse-info-bar-content">
            <div class="immerse-info-bar-title">
              单位
            </div>
            <div class="immerse-info-bar-value">
              千克(kg)
            </div>
          </div>
        </div>
        <div class="immerse-info-bar-unit">
          <div class="immerse-info-bar-icon">
            <UngroupOutlined />
          </div>
          <div class="immerse-info-bar-content">
            <div class="immerse-info-bar-title">
              重量
            </div>
            <div class="immerse-info-bar-value">
              1.5
            </div>
          </div>
        </div>
        <div class="immerse-info-bar-unit">
          <div class="immerse-info-bar-icon">
            <PayCircleOutlined />
          </div>
          <div class="immerse-info-bar-content">
            <div class="immerse-info-bar-title">
              销售价
            </div>
            <div class="immerse-info-bar-value">
              ￥15
            </div>
          </div>
        </div>
      </div>
    </div>
    <a-divider />
    <div class="tabs-panel" size="middle">
      <a-tabs v-model:activeKey="activeKey">
        <a-tab-pane tab="商品详细信息" key="1">
          <div class="commodity-detail-group">
            <div class="commodity-detail-title">
              商品介绍
            </div>
            <div class="commodity-detail-content">
              这是描述
            </div>
          </div>
        </a-tab-pane>
        <a-tab-pane tab="商品BOM集" key="2">
          <a-space direction="vertical" size="large">
            <div class="commodity-detail-group">
              <div class="commodity-detail-title">
                BOM名称
              </div>
              <div class="commodity-detail-content">
                这是描述
              </div>
            </div>
            <div class="commodity-detail-group">
              <div class="commodity-detail-title">
                子件商品
              </div>
              <div class="commodity-detail-content">
                这是描述
              </div>
            </div>
            <div class="commodity-detail-group">
              <div class="commodity-detail-title">
                母件商品
              </div>
              <div class="commodity-detail-content">
                这是描述
              </div>
            </div>
            <div class="commodity-detail-group">
              <div class="commodity-detail-title">
                拆分费用
              </div>
              <div class="commodity-detail-content">
                ￥10.2
              </div>
            </div>
            <div class="commodity-detail-group">
              <div class="commodity-detail-title">
                组装费用
              </div>
              <div class="commodity-detail-content">
                ￥10.2
              </div>
            </div>
            <div class="commodity-detail-group">
              <div class="commodity-detail-title">
                入库商品成本核算方式
              </div>
              <div class="commodity-detail-content">
                IF COST>=5000 THEN RETURN COST*1.25
              </div>
            </div>
          </a-space>
        </a-tab-pane>
        <a-tab-pane tab="SKU" key="3">
          <a-space direction="vertical" size="large">
            <div class="commodity-detail-group">
              <div class="commodity-detail-title">
                SKU色系
              </div>
              <div class="commodity-detail-content">
                <span style="color: white;background: #114514;">#114514</span>
              </div>
            </div>
            <div class="commodity-detail-group">
              <div class="commodity-detail-title">
                SKU尺寸
              </div>
              <div class="commodity-detail-content">
                3×5×5m³
              </div>
            </div>
            <div class="commodity-detail-group">
              <div class="commodity-detail-title">
                SKU重量
              </div>
              <div class="commodity-detail-content">
                12.5kg
              </div>
            </div>
            <div class="commodity-detail-group">
              <div class="commodity-detail-title">
                SKU条形码
              </div>
              <div class="commodity-detail-content">
                <svg class="barcode"></svg>
              </div>
            </div>
          </a-space>
        </a-tab-pane>
      </a-tabs>
    </div>
  </a-drawer>
</template>
<script lang="ts" setup>
import { CarOutlined, BankOutlined, TableOutlined, UngroupOutlined, PayCircleOutlined } from '@ant-design/icons-vue'
import JsBarcode from 'jsbarcode';
import { getCommodityDetailsByCID } from '~@/api/common/commodity';

const props = defineProps({
  open: {
    type: Boolean,
    default: false
  },
  id: {
    type: Number,
    default: -1
  }
})
const activeKey = ref("1");
const emits = defineEmits(['update:open'])
const openE = useVModel(props, "open", emits)
onMounted(() => {
  loadData();
  nextTick(() => {
    JsBarcode('.barcode', '114514', {
      format: 'CODE39',
      width:1,
      height:40,
      displayValue:true,
      fontSize:15,
      margin:15,
      background: "transparent"
    })
  })
})
async function loadData(){
  const { data } = await getCommodityDetailsByCID(props.id)
  data
}

</script>
<style lang="less" scoped>
:root{
  --border-radius: 10px;
}
.immerse-pic-container{
  position: relative;
}
.immerse-pic{
  height: 250px;
  width: 100%;
  object-fit: cover;
  border-radius: var(--border-radius);
}
.img-mask{
  position: absolute;
  top: 0;
  left: 0;
  height: 100%;
  width: 100%;
  background: linear-gradient(to left, rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0));
  border-radius: var(--border-radius);
  display: flex;
  justify-content: right;
  align-items: center;
  padding-right: 40px;
  .commodity-shortcut{
    color: white;
    display: flex;
    flex-direction: column;
    .commodity-name{
      font-size: 3em;
      font-weight: bold;
    }
    .commodity-brand{
      font-size: 1.75em;
      font-family:'Times New Roman', harmony;
    }
  }

}
.tabs-panel{
  .commodity-detail-group{
    .commodity-detail-title{
      color: black;
      font-weight: bold;
      font-size: 16px;
      margin-bottom: 5px;
    }
    .commodity-detail-content{
      line-height: 0.75em;
    }
  }
}
.immerse-info-bar{
  display: flex;
  justify-content: space-between;
  margin: 10px 0;
  .immerse-info-bar-unit{
    display: flex;
    width: 20%;
    .immerse-info-bar-icon{
      font-size: 35px;
      margin-right: 10px;
    }
    .immerse-info-bar-content{
      .immerse-info-bar-title{
        font-size: 17px;
        color: gray;
      }
      .immerse-info-bar-value{
        font-size: 15px;
      }
    }
  }
}
</style>