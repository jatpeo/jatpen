<template>
  <div class="mod-home">
    <h3>博客后台管理系统</h3>
    <panel-group></panel-group>
    <el-row style="background:#fff;padding:16px 16px 0;margin-bottom:32px;">
    </el-row>
  </div>
</template>

<script>
import panelGroup from './components/panelGroup'

export default {

  components: {
    panelGroup
  },
  data () {
    return {
      lineChartData: lineChartData.newVisitis
    }
  }
}
</script>

<style>
  .mod-home {
    line-height: 1.5
  }
</style>
