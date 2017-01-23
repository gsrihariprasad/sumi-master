package com.hcl.selenium.pageactionclass;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum PageActionClassAPI {
	
	CreateRouting {
		public CreateRouting getObject(JSONObject pageinputs,Object obj) {
			Logger logger = LoggerFactory.getLogger(PageActionClassAPI.class);
			CreateRouting createRouting= new CreateRouting();
			createRouting.setCreateRouting_RoutingDescription(pageinputs.getString("createRouting_RoutingDescription"));
			createRouting.setCreateRouting_RoutingIdentifier(pageinputs.getString("createRouting_RoutingIdentifier"));
			createRouting.setCreateRouting_RoutingName(pageinputs.getString("createRouting_RoutingName"));
			createRouting.setCreateRouting_RoutingVersion(pageinputs.getString("createRouting_RoutingVersion"));
			logger.info("AllPageActionClassesService : CreateRouting_RoutingNam:::  "+createRouting.getCreateRouting_RoutingName());
			return createRouting;

		}
	},
	ChangeRouting {
		public ChangeRouting getObject(JSONObject pageinputs,Object obj) {
			Logger logger = LoggerFactory.getLogger(PageActionClassAPI.class);
			return new ChangeRouting();

		}
	},
	CreatSite {
		public CreatSite getObject(JSONObject pageinputs,Object obj) {
			Logger logger = LoggerFactory.getLogger(PageActionClassAPI.class);
			
			CreatSite creatSite=new CreatSite();
			creatSite.setCreateSite_SiteDesc(pageinputs.getString("createSite_SiteDesc"));
			creatSite.setCreateSite_SiteId(pageinputs.getString("createSite_SiteId"));
			return creatSite;

		}
	},
	DeleteRouting {
		public DeleteRouting getObject(JSONObject pageinputs,Object obj) {
			Logger logger = LoggerFactory.getLogger(PageActionClassAPI.class);
			return new DeleteRouting();

		}
	},
	RoutingCreate {
		public RoutingCreate getObject(JSONObject pageinputs,Object obj) {
			Logger logger = LoggerFactory.getLogger(PageActionClassAPI.class);
			return new RoutingCreate();

		}
	},

	RoutingQuickChange {
		Logger logger = LoggerFactory.getLogger(PageActionClassAPI.class);

		/*public RoutingQuickChange getObject(final String RoutingQuickChange_RoutingName,
				final String RoutingQuickChange_RoutingIdentifier, final String RoutingQuickChange_RoutingVersion,
				final String RoutingQuickChange_RoutingDescription) {
			return new RoutingQuickChange();

		}*/

		@Override
		public Object getObject(JSONObject pageinputs,Object obj) {
			// TODO Auto-generated method stub
			return new RoutingQuickChange();
		}
	},
	WareHouseCreate {

		@Override
		public Object getObject(JSONObject pageinputs,Object obj) {
			// TODO Auto-generated method stub
			return new WareHouseCreate();
		}
		/*
		 * public WareHouseCreate getObject(final String wareHouseCreate_SiteId,
		 * final String wareHouseCreate_WareDesc, final String
		 * wareHouseCreate_WareHouseId) { return new WareHouseCreate();
		 * 
		 * }
		 */
	};

	public abstract Object getObject(JSONObject pageinputs,Object obj);
}
// ....CLOSES ///
